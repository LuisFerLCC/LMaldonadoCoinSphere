package io.luisferlcc.ulsb.coinsphere

import android.icu.text.DecimalFormat
import android.icu.text.DecimalFormatSymbols
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import io.luisferlcc.ulsb.coinsphere.models.Currency
import io.luisferlcc.ulsb.coinsphere.models.currencies
import io.luisferlcc.ulsb.coinsphere.ui.theme.CoinSphereTheme
import io.luisferlcc.ulsb.coinsphere.ui.theme.Surface
import java.util.Locale

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoinSphereTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HomeScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun HomeScreen(modifier: Modifier) {
    val priceFormatter = DecimalFormat(
        "$###,###.##",
        DecimalFormatSymbols(Locale.US)
    )

    Column(
        modifier = modifier
            .fillMaxSize()
    ) {

        // Top section
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
        ) {
            Text(
                text = "CoinSphere",
                modifier = Modifier.padding(bottom = 10.dp),
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleLarge,
            )

            InfoCard("Global Market Cap", "$2.18T")
            InfoCard("Fear & Greed", "Neutral (54)")
            InfoCard("Altcoin Season", "No")
        }

        // Table headings
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                TableHeading(
                    text = "#",
                    contentAlignment = Alignment.Center
                )

                TableHeading(
                    text = "Name",
                    modifier = Modifier.weight(10f)
                )

                TableHeading(
                    text = "Price",
                    modifier = Modifier.weight(9f)
                )
            }

            Box(
                modifier = Modifier
                    .background(Surface)
                    .fillMaxWidth()
                    .height(1.dp)
            )
        }

        // List of currencies
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            itemsIndexed(currencies) { index, currency ->
                CurrencyCard(index + 1, currency, priceFormatter)
            }
        }

    }
}

@Composable
fun InfoCard(label: String, value: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(
                    horizontal = 16.dp,
                    vertical = 20.dp
                )
        ) {
            Text(
                text = label,
                style = MaterialTheme.typography.bodyMedium
            )

            Text(
                text = value,
                modifier = Modifier.padding(top = 8.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
        }
    }
}

@Composable
private fun TableHeading(
    text: String,
    modifier: Modifier = Modifier,
    contentAlignment: Alignment = Alignment.CenterStart
) {
    Box(
        modifier = modifier
            .padding(horizontal = 16.dp)
            .height(40.dp),
        contentAlignment = contentAlignment
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.bodyMedium,
        )
    }
}

@Composable
private fun CurrencyCard(
    listNumber: Int,
    currency: Currency,
    priceFormatter: DecimalFormat
) {
    val formattedPrice = priceFormatter.format(currency.price)

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .padding(top = 12.dp),
        shape = RoundedCornerShape(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = listNumber.toString(),
                modifier = Modifier.padding(end = 16.dp),
                style = MaterialTheme.typography.bodyMedium,
            )

            Row(
                modifier = Modifier.weight(3f),
                verticalAlignment = Alignment.CenterVertically
            ) {
                AsyncImage(
                    model = currency.imageUrl,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(end = 12.dp)
                        .clip(CircleShape)
                        .size(32.dp),
                    contentScale = ContentScale.Crop
                )

                Text(
                    text = currency.name,
                )
            }

            Text(
                text = formattedPrice,
                modifier = Modifier.weight(2f)
            )
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun HomeScreenPreview() {
    CoinSphereTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            HomeScreen(
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}
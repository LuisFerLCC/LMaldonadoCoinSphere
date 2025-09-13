package io.luisferlcc.ulsb.coinsphere.models

data class Currency(
    val name: String,
    val price: Double,
    val imageUrl: String
)

val currencies = listOf(
    Currency(
        "Bitcoin",
        109_797.37,
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRaSEEUJQPS_ARZeaL2PTiA5K0qDjwFzMoVQA&s"
    ),
    Currency(
        "Ethereum",
        4_321.21,
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTJDn0ojTITvcdAzMsfBMJaZC4STaDHzduleQ&s"
    ),
    Currency(
        "Tether",
        1.0,
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRGcttVBhyCMnl1e_iNaaK7Z6GRz5WZTlDc3g&s"
    ),
    Currency(
        "XRP",
        2.81,
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcStEx8l1lrrq1h7ap3moMYOl-dmeNzfi3HTOw&s"
    ),
    Currency(
        "BNB",
        845.0,
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTMJrPvmIr6nTC7mcdh7RY5YlDiV0h90WEaKg&s"
    ),
    Currency(
        "Solana",
        201.85,
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTsIsJL3zRgUrkD3yE3lD7LK0wZWSiRyY1GVg&s"
    ),
    Currency(
        "USDC",
        0.99,
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTbBMfDxr1PrxlKVnOBktTGlNgXSVYUT0LB7Q&s"
    ),
    Currency(
        "Dogecoin",
        0.132,
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTf2HxwuBXfjRHOAOGPrbyeJenImodJp68tow&s"
    ),
    Currency(
        "Tron",
        0.363,
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTBsWaz0K2kxYpSFMhQ2pPdBcnOwpQHWYEyzw&s"
    ),
    Currency(
        "Litecoin",
        114.98,
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT3ozDjnjy7W6Tn1U6M5DHmp1XRCIZzefZV_w&s"
    )
)
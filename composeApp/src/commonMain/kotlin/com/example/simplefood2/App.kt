package com.example.simplefood2

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import simplefood2.composeapp.generated.resources.Res
import simplefood2.composeapp.generated.resources.category_dosa
import simplefood2.composeapp.generated.resources.category_kebab
import simplefood2.composeapp.generated.resources.category_pizza
import simplefood2.composeapp.generated.resources.category_pure_veg
import simplefood2.composeapp.generated.resources.ic_add
import simplefood2.composeapp.generated.resources.ic_search
import simplefood2.composeapp.generated.resources.ic_shopping_cart
import simplefood2.composeapp.generated.resources.ic_home
import simplefood2.composeapp.generated.resources.ic_profile
import simplefood2.composeapp.generated.resources.ic_collect
import simplefood2.composeapp.generated.resources.ic_compass
import simplefood2.composeapp.generated.resources.product_garlic_chicken_tikka
import simplefood2.composeapp.generated.resources.product_mediterranean_veg_pasta

@Composable
@Preview
fun App() {
    SimpleFoodTheme {
        HomeScreen(
            modifier = Modifier
            .background(MaterialTheme.colorScheme.primaryContainer)
            .safeContentPadding()
            .fillMaxSize()
        )
    }
}

// THEME (in-file)
@Composable
private fun SimpleFoodTheme(
    darkTheme: Boolean = false,
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) darkColorScheme(
        primary = Color(0xFFFF8A3D),
        onPrimary = Color.Black,
        secondary = Color(0xFFBDBDBD),
        background = Color(0xFF121212),
        surface = Color(0xFF1E1E1E),
        onSurface = Color(0xFFFFFFFF)
    ) else lightColorScheme(
        primary = Color(0xFFFF6B00),
        onPrimary = Color.White,
        secondary = Color(0xFF5F5F5F),
        background = Color(0xFFF1F1F1),
        surface = Color.White,
        onSurface = Color(0xFF000000)
    )

    val typography = Typography(
        headlineSmall = TextStyle(
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Black,
            fontSize = 24.sp
        ),
        headlineMedium = TextStyle(
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Black,
            fontSize = 32.sp,
            lineHeight = 38.4.sp
        ),
        bodyMedium = TextStyle(
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.SemiBold,
            fontSize = 18.sp
        )
    )

    MaterialTheme(colorScheme = colors, typography = typography, content = content)
}

// SCREEN + UI (in-file)
@Composable
private fun HomeScreen(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier.fillMaxSize(),
        color = Color(0xFFF1F1F1)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {
            TopBar()
            Spacer(modifier = Modifier.height(16.dp))
            Title()
            Spacer(modifier = Modifier.height(16.dp))
            SearchBar()
            Spacer(modifier = Modifier.height(24.dp))
            CategoryRow()
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = "Popular now",
                style = MaterialTheme.typography.headlineSmall.copy(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Black,
                    color = Color.Black
                )
            )
            Spacer(modifier = Modifier.height(8.dp))
            PopularNowRow()
            Spacer(modifier = Modifier.height(16.dp))
            BottomPill()
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
private fun TopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
            Bar(width = 36.dp)
            Bar(width = 24.dp)
            Bar(width = 36.dp)
        }
        Image(
            painter = painterResource(Res.drawable.ic_shopping_cart),
            contentDescription = "Cart",
            modifier = Modifier.size(24.dp)
        )
    }
}

@Composable
private fun Bar(width: Dp) {
    Box(
        modifier = Modifier
            .width(width)
            .height(2.dp)
            .clip(RoundedCornerShape(2.dp))
            .background(Color.Black.copy(alpha = 0.8f))
    )
}

@Composable
private fun Title() {
    Text(
        text = "Delicious food.\nSuperfast delivery.",
        color = Color.Black,
        fontSize = 32.sp,
        lineHeight = 38.4.sp,
        fontWeight = FontWeight.Black
    )
}

@Composable
private fun SearchBar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(54.dp)
            .shadow(
                elevation = 4.dp,
                shape = RoundedCornerShape(100.dp),
                clip = false
            )
            .clip(RoundedCornerShape(100.dp))
            .background(Color.White)
    ) {
        Text(
            text = "Search",
            color = Color(0xFFBDBDBD),
            fontSize = 20.sp,
            fontWeight = FontWeight.ExtraLight,
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(start = 20.dp)
        )

        Box(
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .padding(end = 8.dp)
                .size(45.dp)
                .clip(CircleShape)
                .background(Color(0xFFFF6B00)),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(Res.drawable.ic_search),
                contentDescription = "Search",
                modifier = Modifier.size(22.dp)
            )
        }
    }
}

private data class Category(val title: String, val resId: DrawableResource)

@Composable
private fun CategoryRow() {
    val categories = listOf(
        Category("Dosa", Res.drawable.category_dosa),
        Category("Pizza", Res.drawable.category_pizza),
        Category("Pure-Veg", Res.drawable.category_pure_veg),
        Category("Kebab", Res.drawable.category_kebab),
    )
    LazyRow(
        contentPadding = PaddingValues(horizontal = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(categories) { item ->
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Card(
                    shape = RoundedCornerShape(20.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(77.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(item.resId),
                            contentDescription = item.title,
                            modifier = Modifier
                                .size(47.dp)
                                .clip(RoundedCornerShape(10.dp)),
                            contentScale = ContentScale.Crop
                        )
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = item.title,
                    fontSize = 15.sp,
                    fontWeight = if (item.title == "Dosa") FontWeight.Bold else FontWeight.SemiBold,
                    color = if (item.title == "Dosa") Color.Black else Color.Black.copy(alpha = 0.5f),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

private data class Product(
    val title: String,
    val price: String,
    val image: DrawableResource
)

@Composable
private fun PopularNowRow() {
    val products = listOf(
        Product("Garlic Chicken Tikka", "₹180", Res.drawable.product_garlic_chicken_tikka),
        Product("Mediterranean\nVeg Pasta ", "₹150", Res.drawable.product_mediterranean_veg_pasta)
    )

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        products.forEach { product ->
            ProductCard(product = product, modifier = Modifier.weight(1f))
        }
    }
}

@Composable
private fun ProductCard(product: Product, modifier: Modifier = Modifier) {
    Box(modifier = modifier.height(290.dp)) {
        Card(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .height(231.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(25.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
        ) {
            Column(modifier = Modifier.fillMaxSize()) {
                Spacer(modifier = Modifier.height(140.dp))
                Text(
                    text = product.title,
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .padding(top = 8.dp),
                    color = Color(0xFF5F5F5F),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                        .padding(top = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = product.price,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Black,
                        color = Color.Black
                    )
                    Image(
                        painter = painterResource(Res.drawable.ic_add),
                        contentDescription = "Add",
                        modifier = Modifier.size(27.dp)
                    )
                }
            }
        }

        Image(
            painter = painterResource(product.image),
            contentDescription = product.title,
            modifier = Modifier
                .size(141.dp)
                .align(Alignment.TopCenter)
                .offset(y = (-10).dp),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
private fun BottomPill() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .size(width = 336.dp, height = 55.dp)
                .clip(RoundedCornerShape(28.dp))
                .background(Color.White)
        )

        Row(
            modifier = Modifier
                .size(width = 336.dp, height = 55.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(55.dp)
                    .clip(CircleShape)
                    .background(Color(0xFFFF6B00)),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(Res.drawable.ic_home),
                    contentDescription = "Home",
                    modifier = Modifier.size(30.dp)
                )
            }
            Image(painter = painterResource(Res.drawable.ic_collect), contentDescription = "Collect", modifier = Modifier.size(30.dp))
            Image(painter = painterResource(Res.drawable.ic_compass), contentDescription = "Compass", modifier = Modifier.size(30.dp))
            Image(painter = painterResource(Res.drawable.ic_profile), contentDescription = "Profile", modifier = Modifier.size(30.dp))
        }
    }
}
//package com.example.learnandroid
//
//import android.os.Bundle
//import android.widget.Toast
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.height
//import androidx.compose.material3.Button
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import kotlin.random.Random
//
//data class Cart(
//    val products: List<Product>
//)
//
//data class Product(
//    val id: Int,
//    val name: String,
//    val price: Int
//)
//
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            ShoppingCartScreen()
//        }
//    }
//
//    @Composable
//    fun ShoppingCartScreen() {
//        var products by remember {
//            mutableStateOf(
//                listOf(
//                    Product(0, "Товар #1", 100),
//                    Product(1, "Товар #2", 150),
//                    Product(2, "Товар #3", 56)
//                )
//            )
//        }
//
//        val totalSum = products.sumOf { it.price }
//        val productSize = products.size
//        val context = LocalContext.current
//
//        Column {
//            for (product in products) {
//                Text(text = "${product.name} - ${product.price} рублей")
//            }
//
//            Spacer(modifier = Modifier.height(10.dp))
//
//            Text(text = "Товаров на сумму: $totalSum рублей")
//
//            AddProductSection {
//                val nextId = (products.maxOfOrNull { it.id } ?: -1) + 1
//                val newProduct = Product(
//                    id = nextId,
//                    name = "Товар #${products.size + 1}",
//                    price = Random.nextInt(1, 100)
//                )
//                products = products + newProduct
//
//                val newTotal = products.sumOf { it.price }
//                if (newTotal > 500) {
//                    Toast.makeText(context, "Доставка бесплатная!", Toast.LENGTH_SHORT).show()
//                }
//            }
//
//            RemoveProductSection(isVisible = productSize > 0) {
//                products = products.dropLast(1)
//            }
//        }
//    }
//
//    @Composable
//    fun AddProductSection(onAdd: () -> Unit) {
//        Button(onClick = onAdd) {
//            Text(text = "Добавить товар")
//        }
//    }
//
//    @Composable
//    fun RemoveProductSection(
//        isVisible: Boolean,
//        onRemove: () -> Unit
//    ) {
//        if (isVisible) {
//            Button(onClick = onRemove) {
//                Text(text = "Удалить товар")
//            }
//        }
//    }
//}
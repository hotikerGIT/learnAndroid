package com.example.learnandroid

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

data class Contact(
    val name: String,
    val father_name: String,
    val surname: String,
    val phone: String,
    val address: String
)

@Composable
fun ContactCard(
    contact: Contact,
    withBackground: Boolean = false,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .then(
                if (withBackground) Modifier.background(Color.LightGray)
                else Modifier
            )
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Имя: ${contact.name}")
        Text(text = "Отчество: ${contact.father_name}")
        Text(text = "Фамилия: ${contact.surname}")
        Text(text = "Мобильный телефон: ${contact.phone}")
        Text(text = "Адрес: ${contact.address}")
    }
}

object SampleData {
    val test = Contact(
        name = "Test",
        father_name = "Testovich",
        surname = "Testov",
        phone = "+7 777 77 77 77",
        address = "c"
    )
}

@Preview(showBackground = true)
@Composable
fun ContactColumnPreviewSubtask1() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        ContactCard(SampleData.test, withBackground = false, Modifier.fillMaxWidth())
    }
}

@Preview(showBackground = true)
@Composable
fun ContactColumnPreviewSubtask2() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        ContactCard(SampleData.test, true, Modifier.fillMaxWidth())
        ContactCard(SampleData.test, true, Modifier.fillMaxWidth())
        ContactCard(SampleData.test, true, Modifier.fillMaxWidth())
    }
}

@Preview(showBackground = true)
@Composable
fun ContactRowPreview() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(Color.LightGray),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        ContactCard(contact = SampleData.test, withBackground = true)

        Image(
            painter = painterResource(R.drawable.circle),
            contentDescription = null,
            modifier = Modifier.size(48.dp)
        )
    }
}
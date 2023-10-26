package com.ahmedhnewa.composemultiplatform.contacts.presentation.componenets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.ahmedhnewa.composemultiplatform.contacts.domain.Contact
import com.ahmedhnewa.composemultiplatform.core.presentation.rememberBitmapFromBytes

@Composable
fun ContactPhoto(
    modifier: Modifier = Modifier,
    contact: Contact?,
    iconSize: Dp = 25.dp
) {
    val bitmap = rememberBitmapFromBytes(contact?.photoBytes)
    val photoModified = modifier.clip(RoundedCornerShape(35))
    if (bitmap != null) {
        Image(
            modifier = photoModified,
            bitmap = bitmap,
            contentDescription = contact?.firstName ?: "First name Icon",
            contentScale = ContentScale.Crop
        )
    } else {
        Box(
            modifier = photoModified
                .background(MaterialTheme.colorScheme.secondaryContainer),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                modifier = Modifier
                    .size(iconSize),
                imageVector = Icons.Rounded.Person,
                contentDescription = contact?.firstName ?: "First name Icon",
                tint = MaterialTheme.colorScheme.onSecondaryContainer
            )
        }
    }
}
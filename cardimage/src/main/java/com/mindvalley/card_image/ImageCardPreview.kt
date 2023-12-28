package com.mindvalley.card_image

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

@Composable
fun CardImagePreview(
    modifier: Modifier = Modifier,
    image: Painter,
    description: String = "",
    contentDescription: String = "",
    onImageClick: () -> Unit = {},
) {
    Box(
        modifier = modifier
            .aspectRatio(1f)
            .clip(RoundedCornerShape(15.dp))
            .shadow(15.dp, RoundedCornerShape(15.dp))
            .clickable { onImageClick() },
    ) {
        Image(
            painter = image,
            contentDescription = contentDescription,
            contentScale = ContentScale.Crop,
            modifier = modifier.fillMaxSize(),
        )
        Text(
            text = description,
            style = MaterialTheme.typography.bodyMedium,
            color = Color.White,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
            modifier = modifier.fillMaxWidth()
                .background(
                    Brush.verticalGradient(
                        listOf(
                            Color.Transparent,
                            Color.Black,
                        ),
                    ),
                )
                .align(Alignment.BottomStart)
                .padding(8.dp),
        )
    }
}

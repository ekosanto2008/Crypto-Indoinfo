package com.santoso.tech.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FearAndGreedCard(
    value: Int,
    classification: String,
    modifier: Modifier = Modifier
) {
    val color = when (classification.lowercase()) {
        "extreme fear" -> Color(0xFFB71C1C)
        "fear" -> Color(0xFFD32F2F)
        "neutral" -> Color(0xFFFBC02D)
        "greed" -> Color(0xFF388E3C)
        "extreme greed" -> Color(0xFF1B5E20)
        else -> MaterialTheme.colorScheme.primary
    }

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = color.copy(alpha = 0.1f)
        ),
        border = CardDefaults.outlinedCardBorder().copy(
            brush = androidx.compose.ui.graphics.SolidColor(color.copy(alpha = 0.3f))
        )
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    text = "Fear & Greed Index",
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Text(
                    text = classification,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = color
                )
            }
            
            Box(
                modifier = Modifier
                    .size(56.dp)
                    .padding(4.dp),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(
                    progress = value / 100f,
                    modifier = Modifier.fillMaxSize(),
                    color = color,
                    strokeWidth = 6.dp,
                    trackColor = color.copy(alpha = 0.1f)
                )
                Text(
                    text = "$value",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                )
            }
        }
    }
}

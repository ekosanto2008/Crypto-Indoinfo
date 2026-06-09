package com.santoso.tech.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.santoso.tech.domain.model.GlobalMetrics
import java.text.NumberFormat
import java.util.*

@Composable
fun GlobalMetricsCard(
    metrics: GlobalMetrics,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(24.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent)
    ) {
        Box(
            modifier = Modifier
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            MaterialTheme.colorScheme.primary,
                            MaterialTheme.colorScheme.secondary
                        )
                    )
                )
                .padding(20.dp)
        ) {
            Column {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Global Market Cap",
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.8f)
                    )
                    Text(
                        text = "BTC Dominance: ${String.format(Locale.US, "%.1f%%", metrics.btcDominance)}",
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                }
                
                Text(
                    text = formatLargeCurrency(metrics.totalMarketCap),
                    style = MaterialTheme.typography.headlineLarge,
                    fontWeight = FontWeight.Black,
                    color = MaterialTheme.colorScheme.onPrimary,
                    letterSpacing = (-1).sp
                )
                
                Spacer(modifier = Modifier.height(16.dp))
                
                Divider(color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.2f))
                
                Spacer(modifier = Modifier.height(12.dp))
                
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    MetricSmallItem(
                        label = "24h Volume",
                        value = formatLargeCurrency(metrics.totalVolume24h)
                    )
                    MetricSmallItem(
                        label = "USD / IDR",
                        value = formatIdr(metrics.usdToIdrRate)
                    )
                }
            }
        }
    }
}

@Composable
fun MetricSmallItem(label: String, value: String) {
    Column {
        Text(
            text = label,
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.7f)
        )
        Text(
            text = value,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onPrimary
        )
    }
}

fun formatLargeCurrency(amount: Double): String {
    return when {
        amount >= 1_000_000_000_000 -> String.format(Locale.US, "$%.2f T", amount / 1_000_000_000_000)
        amount >= 1_000_000_000 -> String.format(Locale.US, "$%.2f B", amount / 1_000_000_000)
        else -> String.format(Locale.US, "$%.2f M", amount / 1_000_000)
    }
}

fun formatIdr(amount: Double): String {
    val format = NumberFormat.getCurrencyInstance(Locale("in", "ID"))
    return format.format(amount)
}

package evgeny.fetskovich.kmpstudy.app.extensions

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

inline val Int.toDpCompose: Dp
    @Composable get() = with(LocalDensity.current) { this@toDpCompose.toDp() }

inline val Int.dpToPx: Float
    @Composable get() = with(LocalDensity.current) { this@dpToPx.dp.toPx() }
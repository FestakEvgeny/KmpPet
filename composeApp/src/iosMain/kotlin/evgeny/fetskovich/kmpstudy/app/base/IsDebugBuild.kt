package evgeny.fetskovich.kmpstudy.app.base

import kotlin.experimental.ExperimentalNativeApi
import kotlin.native.Platform

@OptIn(ExperimentalNativeApi::class)
actual val isDebug: Boolean = Platform.isDebugBinary
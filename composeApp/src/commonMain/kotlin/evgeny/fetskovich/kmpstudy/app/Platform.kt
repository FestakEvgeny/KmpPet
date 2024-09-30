package evgeny.fetskovich.kmpstudy.app

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
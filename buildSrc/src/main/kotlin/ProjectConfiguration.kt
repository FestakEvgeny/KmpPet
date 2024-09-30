import org.gradle.api.JavaVersion

object ProjectConfiguration {

    // TODO Rename MyProject to your project name
    object MyProject {
        const val packageName = "evgeny.fetskovich.kmpstudy"
        const val versionName = "1.0"

        object Android {
            const val applicationId = packageName
            const val namespace = "$packageName.app"
            const val compileSDK = 34
            const val targetSDK = compileSDK
            const val minSDK = 24
            const val versionCode = 1
        }
    }

    object Compiler {
        const val jvmTarget = "11"
        val javaCompatibility = JavaVersion.VERSION_11
    }
}

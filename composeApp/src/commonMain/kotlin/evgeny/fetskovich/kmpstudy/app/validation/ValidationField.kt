package evgeny.fetskovich.kmpstudy.app.validation

data class ValidationField (
    val text: String,
    val errorMessage: String? = null,
) {

    val isValid = errorMessage == null
}
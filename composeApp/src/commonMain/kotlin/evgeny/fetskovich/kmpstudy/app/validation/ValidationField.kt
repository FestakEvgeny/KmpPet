package evgeny.fetskovich.kmpstudy.app.validation

data class ValidationField (
    val text: String,
    val errorMessage: String?,
) {

    val isValid = errorMessage == null
}
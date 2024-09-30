package evgeny.fetskovich.kmpstudy.app.architecture.mvi

interface UserEventProcessor {

    fun processEvent(userEvent: UserEvent)
}

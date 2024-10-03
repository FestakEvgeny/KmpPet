package evgeny.fetskovich.kmpstudy.app.architecture.mvi

interface UserEventProcessor {

    fun processEvent(userEvent: UserEvent)
}

object MockUserEventProcessor : UserEventProcessor {

    override fun processEvent(userEvent: UserEvent) {
        // do nothing
    }
}
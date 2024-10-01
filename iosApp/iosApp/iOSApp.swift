import SwiftUI
import ComposeApp

@main
struct iOSApp: App {

    init() {
        KoinIosDIKt.doInitKoin()
    }

    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}
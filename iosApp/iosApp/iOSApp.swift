import SwiftUI
import shared

@main
struct iOSApp: App {

    required init() {
        KoinIosDIKt.doInitKoin()
    }

    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}
import UIKit
import SwiftUI
import ComposeApp

struct ComposeView: UIViewControllerRepresentable {

    var onSongSelect: () -> Void  // <-- pass Swift callback here

    func makeUIViewController(context: Context) -> UIViewController {
        // pass the Swift callback to Kotlin
        PlayListViewControllerKt.PlayListViewController(onSongSelect: onSongSelect)
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
}

struct ContentView: View {
    
    var onSongSelect: () -> Void
    
    var body: some View {
        ComposeView(onSongSelect: onSongSelect)
            .ignoresSafeArea()

    }
}




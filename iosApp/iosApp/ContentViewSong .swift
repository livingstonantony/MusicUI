import UIKit
import SwiftUI
import ComposeApp

struct ComposeViewSong: UIViewControllerRepresentable {
    func makeUIViewController(context: Context) -> UIViewController {
        SongProgressViewControllerKt.SongProgressViewController()
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
}

struct ContentViewSong: View {
    
    var body: some View {
        ComposeViewSong()
            .ignoresSafeArea()
    }
}




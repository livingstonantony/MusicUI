//
//  NavApp.swift
//  iosApp
//
//  Created by Philosopher on 21/01/26.
//

import Foundation
import SwiftUI

enum AppScreen {
    case login
    case home
    case song
}

struct RootView: View {

    @State private var screen: AppScreen = .login

    var body: some View {
        switch screen {
        case .login:
            LoginScreen {
                screen = .home  // replace screen
            }

        case .home:
            ContentView {
                screen = .song
            }
        case .song:
            SongScreen {
                screen = .home
            }
        }

    }
}

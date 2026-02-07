//
// Created by Philosopher on 21/01/26.
//

import SwiftUI

let imageURL =
"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRuPmHmmNbZ_SlYoMtYbGIfyobXo5sZ_TyrvQ&s"

struct LoginScreen: View {
    
    let login: () -> Void
    
    var body: some View {
        
        ZStack(alignment: .topTrailing){
            VStack(spacing: 0) {
                Spacer()
                
                VStack(spacing: 0) {
                    
                    AsyncImage(url: URL(string: imageURL)) { image in
                        image
                            .resizable()
                            .scaledToFill()
                    } placeholder: {
                        ProgressView()
                    }
                    .frame(width: 300, height: 300)
                    .clipShape(Circle())
                    
                    Spacer().frame(height: 32)
                    
                    Text("Listen to the best podcast")
                        .font(
                            .system(size: 28, weight: .heavy, design: .monospaced)
                        )
                        .multilineTextAlignment(.center)
                    
                    Spacer().frame(height: 8)
                    
                    Text(
                        """
                        Literally it does not mean anything.
                        it is sequence
                        """
                    )
                    .font(.system(size: 16, design: .monospaced))
                    .multilineTextAlignment(.center)
                    .foregroundColor(.secondary)
                    
                    Spacer().frame(height: 24)
                    
                    Button(action: login) {
                        Text("Login")
                            .foregroundColor(.white)
                            .frame(maxWidth: .infinity)
                            .frame(height: 60)
                            .background(Color.black)
                            .cornerRadius(12)
                    }
                    
                    Spacer().frame(height: 10)
                    
                    Button(action: {}) {
                        Text("Signup")
                            .foregroundColor(.black)
                            .frame(maxWidth: .infinity)
                            .frame(height: 60)
                            .overlay(
                                RoundedRectangle(cornerRadius: 12)
                                    .stroke(Color.black, lineWidth: 1)
                            )
                    }
                }
                .padding(20)
                
                Spacer()
            }
            Text("SwiftUI")
                .font(.caption)
                .fontWeight(.bold)
                .padding(8)
                .background(Color.accentColor.opacity(0.9))
                .foregroundColor(.white)
                .cornerRadius(8)
                .padding(12)
        }
        
        
        
        
    }
    
}

struct LoginScreen_Previews: PreviewProvider {
    static var previews: some View {
        LoginScreen {
            print("Login clicked")
        }
    }
}

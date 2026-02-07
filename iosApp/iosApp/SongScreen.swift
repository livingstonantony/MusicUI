import SwiftUI

import SwiftUI

struct SongScreen: View {

    var back: () -> Void

    let imageURL = URL(
        string: "https://clipart-library.com/2024/musics/musics-1.jpg"
    )

    var body: some View {

        VStack {

            VStack(spacing: 16) {

                // Main Image
                AsyncImage(url: imageURL) { image in
                    image
                        .resizable()
                        .scaledToFill()
                } placeholder: {
                    ProgressView()
                }
                .frame(width: 280, height: 280)
                .clipShape(Circle())

                // Title Row
                HStack {

                    VStack(alignment: .leading, spacing: 4) {
                        Text("The Striving")
                            .font(.headline)

                        Text("Aadesh Chouhan")
                            .font(.subheadline)
                            .foregroundColor(.gray)
                    }

                    Spacer()

                    AsyncImage(url: imageURL) { image in
                        image
                            .resizable()
                            .scaledToFill()
                    } placeholder: {
                        ProgressView()
                    }
                    .frame(width: 70, height: 70)
                    .clipped() // ✅ add clip
                    .clipShape(RoundedRectangle(cornerRadius: 12))
                }
                .frame(maxWidth: .infinity)

                ContentViewSong()
            }
            .frame(maxWidth: .infinity)   // ✅ IMPORTANT
            .padding()
            .multilineTextAlignment(.center)
        }
        .frame(maxWidth: .infinity, maxHeight: .infinity)

        .safeAreaInset(edge: .top) {
            ToolTopBar(
                title: "Now Playing",
                onBack: back,
                onFav: {
                    print("Fav tapped")
                }
            )
        }
    }
}

struct ToolTopBar: View {

    let title: String
    let onBack: () -> Void
    let onFav: () -> Void

    var body: some View {
        HStack {

            Button(action: onBack) {
                Image(systemName: "chevron.left")
                    .font(.title3)
            }

            Spacer()

            Text(title)
                .font(.headline)
            Text("SwiftUI")
                .padding(.horizontal,8)
                .background(Color.accentColor.opacity(0.9))
                .foregroundColor(.white)
                .cornerRadius(4)

            Spacer()

            Button(action: onFav) {
                Image(systemName: "heart")
                    .font(.title3)
            }
        }
        .padding()
        .background(.ultraThinMaterial)
    }
}

struct SongScreen_Previews: PreviewProvider {
    static var previews: some View {
        SongScreen {
            print("Login clicked")
        }
    }
}

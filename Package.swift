//swift-tools-version: 5.7.1
import PackageDescription

let packageName = "shared"

let package = Package(
    name: packageName,
    platforms: [ .iOS(.v13)],
    products: [
        .library(
            name: packageName,
            targets: [packageName]
        )
    ],
    targets: [
        .binaryTarget(
            name: packageName,
            path: "./XCFrameworks/debug/shared.xcframework"
        )
    ],
    swiftLanguageVersions: [.v5]
)

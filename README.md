# Flagsmith Test Android App

An Android application test and display Flagsmith feature flags.

## Table of Contents

- [Overview](#overview)
- [Getting Started](#getting-started)
- [Development](#development)
- [Architecture](#architecture)
- [Testing](#testing)
- [Deployment](#deployment)
- [Security](#security)
- [Contributing](#contributing)
- [Support](#support)

## Overview

### What This Mobile Application Does

This Android application serves as a testing and demonstration tool for Flagsmith feature flag functionality. It provides a modern, intuitive interface for viewing and interacting with feature flags in real-time.

### Key Features

- **Jetpack Compose UI** - Modern declarative UI framework
- **Material 3 Design** - Latest Material Design system with dark/light mode support
- **Pull-to-refresh** - Swipe down to refresh feature flags from the server
- **Feature flag display** - Shows flag status with color-coded badges and detailed information
- **Responsive design** - Works seamlessly on phones and tablets
- **Environment configuration** - Configurable environment keys for different Flagsmith environments

### Platform Support

- **Android**: API level 26 and above (Android 8.0)
- **Devices**: Supports phones and tablets with responsive design

## Getting Started

### Prerequisites

- **Development Environment**: Android Studio Hedgehog or later
- **Platform SDKs**: Android SDK 35
- **Additional Tools**: Kotlin 2.0

### Installation

#### Clone and Setup

```bash
git clone <repository-url>
cd flagsmith-test
```

#### Platform-Specific Setup

**Android Setup:**

- Android Studio configuration with Kotlin support
- Gradle wrapper setup (included in project)
- Android SDK 35 and build tools
- No special keystore setup required for development

### Quick Start

1. Copy `local.properties.example` to `local.properties`
2. Add your Flagsmith environment key to `local.properties`
3. Open project in Android Studio and sync
4. Build and run on device/emulator

## Development

### Development Environment Setup

#### Required Tools and Versions

- **Android Studio**: Hedgehog (2023.1.1) or later
- **JDK**: 17 or later
- **Android SDK**: API 35
- **Kotlin**: 2.0

#### Configuration Files

- `local.properties` - Local environment key configuration (not in version control)
- `local.properties.example` - Template for environment configuration
- `app/build.gradle.kts` - Build configuration and dependencies

### Build Instructions

#### Mobile Application Builds

##### Development Builds

```bash
./gradlew assembleDebug
```

### Code Standards and Conventions

- **Naming conventions**: PascalCase for classes, camelCase for functions and variables
- **Architecture patterns**: MVVM with Compose state management

### Debug Menu and Development Tools

- Android Studio debugger integration
- Compose layout inspector support
- Logcat integration for debugging
- Pull-to-refresh for manual testing

## Architecture

### High-Level Architecture

The application follows a modern Android architecture with Jetpack Compose for UI and reactive state management. The app uses a single-activity architecture with Compose navigation.

### Design Patterns

- **MVVM**: Model-View-ViewModel architecture
- **State Management**: Compose state hoisting and unidirectional data flow
- **Repository Pattern**: Flagsmith SDK integration layer

### Data Flow and State Management

- **UI State**: Managed through Compose's state system with sealed classes
- **Data Fetching**: Reactive updates from Flagsmith SDK
- **State Updates**: Automatic UI recomposition on data changes

### Key Frameworks and Libraries

- **Jetpack Compose BOM** (2024.08.00): UI framework and components
- **Material 3**: Design system and theming
- **Flagsmith Android SDK** (1.8.0): Feature flag management and API integration
- **Kotlin Coroutines**: Asynchronous programming

### Security Architecture

- Environment keys managed through local configuration files
- No hardcoded secrets in source code
- Secure network communication through Flagsmith SDK

## Testing

Testing framework not yet implemented.

## Deployment

### Build and Release Process

Standard Android app release process with signed APK/AAB generation for distribution.

### Environment Configurations

- **Development**: Local development with test environment keys
- **Staging**: Pre-production testing environment
- **Production**: Live production feature flag environment

### Distribution and Publishing

#### Mobile Application Store Submission

**Google Play Store**
Standard Google Play Console submission process with signed release builds.

### Continuous Integration

Project ready for CI/CD integration with standard Android build commands.

## Security

### Data Protection

- Environment keys stored in local configuration files excluded from version control
- No sensitive data cached or stored locally beyond session scope

### Authentication and Authorization

Authentication handled through Flagsmith environment keys with proper access controls.

### Network Security

- HTTPS communication through Flagsmith SDK
- Certificate pinning available through SDK configuration

### Privacy and Compliance

- No personal data collection beyond basic feature flag usage
- Compliant with standard Android privacy guidelines

## Contributing

### Development Workflow

Standard Git workflow with feature branches and pull requests.

### Code Review Process

All changes require code review before merging to main branch.

### Issue Reporting

Use GitHub issues for bug reports and feature requests.

## Support

### Documentation

- **README**: This file provides comprehensive setup and usage information
- **Code Documentation**: Inline documentation for key components and functions

### Contact Information

Contact the development team for support and questions.

### Troubleshooting

**Common Issues:**

- **Build Failures**: Ensure Android SDK and build tools are properly installed
- **Environment Key Issues**: Verify `local.properties` file exists and contains valid key
- **Sync Issues**: Clean and rebuild project if Gradle sync fails

## License

Demostration use only.

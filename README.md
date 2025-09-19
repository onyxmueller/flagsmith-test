# Flagsmith Test Android App

A simple Android app that displays Flagsmith feature flags with pull-to-refresh functionality.

## What it does

This app connects to Flagsmith and displays your feature flags in a clean Material 3 interface. Each flag shows its name, enabled/disabled status, and value (if any). Pull down to refresh and get the latest flag states from your Flagsmith environment.

## Quick Setup

1. Copy `local.properties.example` to `local.properties`
2. Add your Flagsmith environment key: `FLAGSMITH_ENVIRONMENT_KEY=your_key_here`
3. Open in Android Studio and run

## Requirements

- Android Studio Hedgehog or later
- Android API 26+ (Android 8.0)
- Flagsmith environment key

## Build

```bash
./gradlew assembleDebug
```

package com.example.flagsmithtest

data class FeatureFlag(
    val name: String,
    val enabled: Boolean,
    val value: String?
)
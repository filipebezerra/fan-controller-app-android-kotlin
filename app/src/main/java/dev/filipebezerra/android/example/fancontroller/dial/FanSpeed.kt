package dev.filipebezerra.android.example.fancontroller.dial

import dev.filipebezerra.android.example.fancontroller.R

enum class FanSpeed(val label: Int) {
    OFF(R.string.fan_off),
    LOW(R.string.fan_low),
    MEDIUM(R.string.fan_medium),
    HIGH(R.string.fan_high);
}
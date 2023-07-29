package com.season.winter.ui.model.fragment.home

enum class ShortcutMenuEvent {
    Best,
    Discount,
    FirstComeFirstServed,
    Draw,
    New,
    MDPick,
    DirectShipping,
    ;
}

data class ShortcutMenuData(
    val event: ShortcutMenuEvent,
    val thumbImageUrl: String,
    val title: String,
)

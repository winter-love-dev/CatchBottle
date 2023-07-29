package com.season.winter.ui.model.fragment.home

//object ShortcutMenuEvent {
//    const val Best = 0
//    const val Discount = 1
//}

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
//    val event: Int,
    val event: ShortcutMenuEvent,
    val thumbImageUrl: String,
    val title: String,
)

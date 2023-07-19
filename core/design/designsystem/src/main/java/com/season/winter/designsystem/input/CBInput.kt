package com.season.winter.designsystem.input

import com.season.winter.designsystem.R
import com.season.winter.designsystem.spacing.Spacing

enum class CBInput(
    val styleRes: Int,
    val paddingLeftRes: Int = Spacing.M.value,
    val paddingTopRes: Int = Spacing.M.value,
    val paddingRightRes: Int = Spacing.M.value,
    val paddingBottomRes: Int = Spacing.M.value,
) {

    First(
        R.drawable.cb_input_first,
    ),
    FirstFocused(R.drawable.cb_input_first_focused),
    Ghost(R.drawable.cb_input_ghost),
    GhostFocused(R.drawable.cb_input_ghost_focused),
    Search(
        R.drawable.cb_input_search,
        paddingTopRes = Spacing.S.value,
        paddingBottomRes = Spacing.S.value,
    ),
    SearchFocused(
        R.drawable.cb_input_search_focused,
        paddingTopRes = Spacing.S.value,
        paddingBottomRes = Spacing.S.value,
    ),
    ;

    companion object {
        const val first = 0
        private const val ghost = 1
        private const val search = 2

        fun getCBInputInfo(type: Int): CBInput {
            return when(type) {
                first -> First
                ghost -> Ghost
                search -> Search
                else -> First
            }
        }
        fun getType(type: Int, isFocused: Boolean): Int {
            return when(type) {
                first -> if (isFocused) FirstFocused.styleRes else First.styleRes
                ghost -> if (isFocused) GhostFocused.styleRes else Ghost.styleRes
                search -> if (isFocused) SearchFocused.styleRes else Search.styleRes
                else -> if (isFocused) FirstFocused.styleRes else First.styleRes
            }
        }
    }
}
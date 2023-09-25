package com.season.winter.designsystem.input

import com.season.winter.designsystem.R
import com.season.winter.designsystem.spacing.CBSpacing

enum class CBInputStyle(
    val styleRes: Int,
    val paddingLeftRes: Int = CBSpacing.M.value,
    val paddingTopRes: Int = CBSpacing.M.value,
    val paddingRightRes: Int = CBSpacing.M.value,
    val paddingBottomRes: Int = CBSpacing.M.value,
) {

    First(
        R.drawable.cb_input_first,
    ),
    FirstFocused(R.drawable.cb_input_first_focused),
    Ghost(R.drawable.cb_input_ghost),
    GhostFocused(R.drawable.cb_input_ghost_focused),
    Search(
        R.drawable.cb_input_search,
        paddingTopRes = CBSpacing.S.value,
        paddingBottomRes = CBSpacing.S.value,
    ),
    SearchFocused(
        R.drawable.cb_input_search_focused,
        paddingTopRes = CBSpacing.S.value,
        paddingBottomRes = CBSpacing.S.value,
    ),
    ;

    companion object {
        const val first = 0
        private const val ghost = 1
        private const val search = 2

        fun getCBInputInfo(type: Int): CBInputStyle {
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
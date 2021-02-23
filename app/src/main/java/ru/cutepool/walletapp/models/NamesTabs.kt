package ru.cutepool.walletapp.models

import ru.cutepool.walletapp.R

enum class NamesTabs (val nameResource: Int) {
    DAILY(R.string.daily_tab_text),
    WEEKLY(R.string.weekly_tab_text),
    MONTHLY(R.string.monthly_tab_text),
    YEARLY(R.string.yearly_tab_text)
}

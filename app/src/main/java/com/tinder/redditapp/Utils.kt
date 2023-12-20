package com.tinder.redditapp

import android.text.format.DateUtils

object Utils {
    fun formatPostTimestamp(createdTimestamp: Long): String {
        val currentTimeMillis = System.currentTimeMillis()
        val timeDifferenceMillis = currentTimeMillis - createdTimestamp

        return when {
            timeDifferenceMillis < 2 * DateUtils.MINUTE_IN_MILLIS -> "a few minutes ago"
            timeDifferenceMillis < 15 * DateUtils.MINUTE_IN_MILLIS -> "${timeDifferenceMillis / DateUtils.MINUTE_IN_MILLIS} minutes ago"
            timeDifferenceMillis < DateUtils.HOUR_IN_MILLIS -> "1 hour ago"
            timeDifferenceMillis < 2 * DateUtils.HOUR_IN_MILLIS -> "1 hour ago"
            timeDifferenceMillis < DateUtils.DAY_IN_MILLIS -> "${timeDifferenceMillis / DateUtils.HOUR_IN_MILLIS} hours ago"
            timeDifferenceMillis < 2 * DateUtils.DAY_IN_MILLIS -> "1 day ago"
            else -> "${timeDifferenceMillis / DateUtils.DAY_IN_MILLIS} days ago"
        }
    }
}
package com.zel.igor.verkhovnarada.data.api.mapper

import com.zel.igor.verkhovnarada.data.model.BillConsiderationState

class BillConsiderationStateMapper {
    companion object {
        fun map(state: String?): BillConsiderationState {
            return when (state) {
                "Одержано проект" -> BillConsiderationState.Received
                "Опрацьовується в комітеті" -> BillConsiderationState.InCommittee
                "Очікує розгляду" -> BillConsiderationState.WaitingForConsideration
                "Закон підписано" -> BillConsiderationState.Signed
                else -> BillConsiderationState.Unknown
            }
        }
    }
}
package com.zel.igor.verkhovnarada.data.api.mapper

import com.zel.igor.verkhovnarada.data.model.BillConsiderationState

class BillConsiderationStateMapper {
    companion object {
        fun map(state: String?): BillConsiderationState {
            return when (state) {
                "Одержано проект" -> BillConsiderationState.Received
                "Опрацьовується в комітеті" -> BillConsiderationState.InCommittee
                "В порядок денний не включено" -> BillConsiderationState.NotIncludedInAgenda
                "Очікує розгляду" -> BillConsiderationState.WaitingForConsideration
                "Розгляд відкладено" -> BillConsiderationState.ConsiderationPostponed
                "Знято з розгляду" -> BillConsiderationState.ConsiderationCanceled
                "Готується на друге читання" -> BillConsiderationState.PreparingForSecondConsideration
                "Готується на підпис" -> BillConsiderationState.PreparingForSign
                "Закон підписано" -> BillConsiderationState.Signed
                else -> BillConsiderationState.Unknown
            }
        }
    }
}
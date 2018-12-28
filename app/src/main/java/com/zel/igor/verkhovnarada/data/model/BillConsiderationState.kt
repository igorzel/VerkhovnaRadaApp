package com.zel.igor.verkhovnarada.data.model

enum class BillConsiderationState {
    Received,
    InCommittee,
    NotIncludedInAgenda,
    WaitingForConsideration,
    ConsiderationPostponed,
    ConsiderationCanceled,
    PreparingForSecondConsideration,
    PreparingForSign,
    Signed,
    Unknown
}

package com.zel.igor.verkhovnarada.data.api.mapper

import com.zel.igor.verkhovnarada.data.model.BillConsiderationState
import org.junit.Assert.assertEquals
import org.junit.Test

class BillConsiderationStateMapperTest {
    @Test
    fun expectedValue() {
        assertEquals(BillConsiderationState.Received, BillConsiderationStateMapper.map("Одержано проект"))
        assertEquals(BillConsiderationState.InCommittee, BillConsiderationStateMapper.map("Опрацьовується в комітеті"))
    }

    @Test
    fun unexpectedValue() {
        assertEquals(BillConsiderationState.Unknown, BillConsiderationStateMapper.map("unexpected value"))
    }

    @Test
    fun nullValue() {
        assertEquals(BillConsiderationState.Unknown, BillConsiderationStateMapper.map(null))
    }
}
package com.velmie.apierrorhandler

import org.junit.jupiter.api.Assertions.assertEquals
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

object SingleProcessedAPIErrorSpec : Spek({
    describe("Target") {
        describe("isTargetField") {
            it("should return TRUE if target is field") {
                val error = SingleProcessedAPIError("unknown_code", APIErrorTarget.FIELD)
                assertEquals(true, error.isTargetField())
            }

            it("should return FALSE if target isn't field") {
                val error = SingleProcessedAPIError("unknown_code", APIErrorTarget.COMMON)
                assertEquals(false, error.isTargetField())
            }
        }

        describe("isTargetCommon") {
            it("should return TRUE if target is common") {
                val error = SingleProcessedAPIError("unknown_code", APIErrorTarget.COMMON)
                assertEquals(true, error.isTargetCommon())
            }

            it("should return FALSE if target isn't common") {
                val error = SingleProcessedAPIError("unknown_code", APIErrorTarget.FIELD)
                assertEquals(false, error.isTargetCommon())
            }
        }
    }
})
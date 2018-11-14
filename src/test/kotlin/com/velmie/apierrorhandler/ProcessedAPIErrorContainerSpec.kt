package com.velmie.apierrorhandler

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.assertThrows
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

object ProcessedAPIErrorContainerSpec : Spek({
    describe("Instantiating") {
        it("should throw IllegalArgumentException exception if array of error is empty") {
            assertThrows<IllegalArgumentException> { ProcessedAPIErrorContainer(arrayOf()) }
        }
    }

    describe("Delegation") {
        it("should delegate all requests to inner object") {
            val singleError = SingleProcessedAPIError("unknown_code", APIErrorTarget.FIELD)
            val errorContainer = ProcessedAPIErrorContainer(arrayOf(singleError))

            assertEquals(singleError.getCode(), errorContainer.getCode())
            assertEquals(singleError.getTarget(), errorContainer.getTarget())
            assertEquals(singleError.getMessage(), errorContainer.getMessage())
            assertEquals(singleError.getSource(), errorContainer.getSource())
            assertEquals(singleError.getCause(), errorContainer.getCause())
        }

        it("should prefer delegation to COMMON error over field error") {
            val singleErrorField1 = SingleProcessedAPIError("unknown_code_f1", APIErrorTarget.FIELD)
            val singleErrorField2 = SingleProcessedAPIError("unknown_code_f2", APIErrorTarget.FIELD)
            val singleErrorCommon = SingleProcessedAPIError("unknown_code_com", APIErrorTarget.COMMON)
            val singleErrorField3 = SingleProcessedAPIError("unknown_code_f3", APIErrorTarget.FIELD)

            val errorContainer = ProcessedAPIErrorContainer(
                    arrayOf(singleErrorField1, singleErrorField2, singleErrorCommon, singleErrorField3)
            )

            assertEquals(singleErrorCommon.getCode(), errorContainer.getCode())
            assertEquals(singleErrorCommon.getTarget(), errorContainer.getTarget())
            assertEquals(singleErrorCommon.getMessage(), errorContainer.getMessage())
            assertEquals(singleErrorCommon.getSource(), errorContainer.getSource())
            assertEquals(singleErrorCommon.getCause(), errorContainer.getCause())
        }
    }
})
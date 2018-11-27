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

        describe("getTarget") {
            val error1 = SingleProcessedAPIError("unknown_code", APIErrorTarget.COMMON)
            val error2 = SingleProcessedAPIError("unknown_code", APIErrorTarget.FIELD)

            it("should return TRUE if target equals preassigned") {
                assertEquals(true, error1.getTarget().body == "common")
                assertEquals(true, error2.getTarget().body == "field")
            }

            it("should return FALSE if equals does not equal preassigned") {
                assertEquals(false, error1.getTarget().body == "unknown")
                assertEquals(false, error2.getTarget().body == "other")
            }
        }
    }

    describe("code") {
        describe("getCode") {
            val error = SingleProcessedAPIError("unknown_code", APIErrorTarget.FIELD)

            it("should return TRUE if entity contains preassigned code") {
                assertEquals(true, error.getCode() == "unknown_code")
            }

            it("should return FALSE if entity does not contain preassigned code") {
                assertEquals(false, error.getCode() == "wrong_code")
            }
        }
    }

    describe("message") {
        describe("getMessage") {
            val error = SingleProcessedAPIError("unknown_code", APIErrorTarget.FIELD, null, "message")

            it("should return TRUE if entity contains preassigned message") {
                assertEquals(true, error.getMessage() == "message")
            }

            it("should return FALSE if entity does not contain preassigned message") {
                assertEquals(false, error.getMessage() == "wrong_message")
            }

            it("should return TRUE if entity contains null message") {
                val error2 = SingleProcessedAPIError("unknown_code", APIErrorTarget.FIELD, null, null)
                assertEquals(true, error2.getMessage() == null)
            }
        }

        describe("hasMessage") {
            it("should return TRUE if entity contains message") {
                val error = SingleProcessedAPIError("unknown_code", APIErrorTarget.FIELD, null, "message")
                assertEquals(true, error.hasMessage())
            }

            it("should return FALSE if entity does not contain message") {
                val error = SingleProcessedAPIError("unknown_code", APIErrorTarget.FIELD, null, null)
                assertEquals(false, error.hasMessage())
            }

            it("should return FALSE if entity contains empty message") {
                val error = SingleProcessedAPIError("unknown_code", APIErrorTarget.FIELD, null, "")
                assertEquals(false, error.hasMessage())
            }
        }
    }

    describe("source") {
        describe("getSource") {
            val error = SingleProcessedAPIError("unknown_code", APIErrorTarget.FIELD, mapOf("key" to "value"))

            it("should return TRUE if entity contains preassigned source") {
                assertEquals(true, error.getSource()?.keys?.first() == "key")
                assertEquals(true, error.getSource()?.values?.first() == "value")
                assertEquals(true, error.getSource() == mapOf("key" to "value"))
            }

            it("should return FALSE if entity does not contain preassigned source") {
                assertEquals(false, error.getSource()?.keys?.first() == "wrong_key")
                assertEquals(false, error.getSource()?.values?.first() == "wrong_value")
                assertEquals(false, error.getSource() == mapOf("other_key" to "value"))
            }

            it("should return TRUE if source size is correct") {
                assertEquals(true, error.getSource()?.size == 1)
            }

            it("should return FALSE if source size is incorrect") {
                assertEquals(false, error.getSource()?.size == 2)
            }

            it("should return TRUE if entity contains null source") {
                val error2 = SingleProcessedAPIError("unknown_code", APIErrorTarget.FIELD, null)
                assertEquals(true, error2.getSource() == null)
            }
        }

        describe("hasSource") {
            it("should return TRUE if entity contains source") {
                val error = SingleProcessedAPIError("unknown_code", APIErrorTarget.FIELD, mapOf("key" to "value"))
                assertEquals(true, error.hasSource())
            }

            it("should return FALSE if entity does not contain source") {
                val error = SingleProcessedAPIError("unknown_code", APIErrorTarget.FIELD, null)
                assertEquals(false, error.hasSource())
            }
        }
    }

    describe("cause") {
        describe("getCause") {
            it("should return TRUE if entity has exception with preassigned fields") {
                val error = SingleProcessedAPIError("code", APIErrorTarget.FIELD, null,
                        null, ResponseException(404, "not_found"))
                assertEquals(true, error.getCause() is ResponseException)
                assertEquals(true, error.getCause()?.code == 404)
                assertEquals(true, error.getCause()?.body == "not_found")
            }

            it("should return TRUE if exception null") {
                val error = SingleProcessedAPIError("code", APIErrorTarget.FIELD, null, null, null)
                assertEquals(true, error.getCause() == null)
            }
        }
    }
})
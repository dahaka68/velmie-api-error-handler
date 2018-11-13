package com.velmie.apierrorhandler

class ProcessedAPIErrorContainer(val errors: Array<SingleProcessedAPIError>) :
    SingleProcessedAPIError(errors.find { it.isTargetCommon() } ?: errors[0])
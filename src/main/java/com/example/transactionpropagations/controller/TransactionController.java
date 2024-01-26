package com.example.transactionpropagations.controller;

import com.example.transactionpropagations.service.LibraryService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/transaction")
@RestController
public class TransactionController {
    private final LibraryService libraryService;

    public TransactionController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @PostMapping("/propagation/required")
    public void requiredPropagation() {
        libraryService.requiredPropagation();
    }

    @PostMapping("/propagation/supports")
    public void supportsPropagation(@RequestParam(required = true) Boolean withinTransaction) {
        if (withinTransaction) {
            // This method will be called within a transaction
            libraryService.callWithinTransaction(() -> libraryService.supportsPropagation());
        } else {
            // This method will be called without a transaction
            libraryService.callWithoutTransaction(() -> libraryService.supportsPropagation());
        }
    }

    @PostMapping("/propagation/mandatory")
    public void mandatoryPropagation(@RequestParam(required = true) Boolean withinTransaction) {
        if (withinTransaction) {
            // This method will be called within a transaction
            libraryService.callWithinTransaction(() -> libraryService.mandatoryPropagation());
        } else {
            // This method will be called without a transaction
            libraryService.callWithoutTransaction(() -> libraryService.mandatoryPropagation());
        }
    }

    @PostMapping("/propagation/requires-new")
    public void requiresNewPropagation(@RequestParam(required = true) Boolean withinTransaction) {
        if (withinTransaction) {
            // This method will be called within a transaction
            libraryService.callWithinTransaction(() -> libraryService.requiresNewPropagation());
        } else {
            // This method will be called without a transaction
            libraryService.callWithoutTransaction(() -> libraryService.requiresNewPropagation());
        }
    }
    @PostMapping("/propagation/not-supported")
    public void notSupportedPropagation(@RequestParam(required = true) Boolean withinTransaction) {
        if (withinTransaction) {
            // This method will be called within a transaction
            libraryService.callWithinTransaction(() -> libraryService.notSupportedPropagation());
        } else {
            // This method will be called without a transaction
            libraryService.callWithoutTransaction(() -> libraryService.notSupportedPropagation());
        }
    }
    @PostMapping("/propagation/never")
    public void neverPropagation(@RequestParam(required = true) Boolean withinTransaction) {
        if (withinTransaction) {
            // This method will be called within a transaction
            libraryService.callWithinTransaction(() -> libraryService.neverPropagation());
        } else {
            // This method will be called without a transaction
            libraryService.callWithoutTransaction(() -> libraryService.neverPropagation());
        }
    }


}

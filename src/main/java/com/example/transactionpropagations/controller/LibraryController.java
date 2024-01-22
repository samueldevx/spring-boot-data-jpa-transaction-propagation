package com.example.transactionpropagations.controller;

import com.example.transactionpropagations.service.LibraryService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/transaction")
@RestController
public class LibraryController {
    private final LibraryService libraryService;

    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @PostMapping("/propagation/required")
    public void requiredPropagation() {
        libraryService.requiredPropagation();
    }

    @PostMapping("/propagation/supports")
    public void supportsPropagation() {
        // This method will be called within a transaction
        libraryService.callWithinTransaction(() -> libraryService.supportsPropagation());
        // This method will be called without a transaction
        libraryService.callWithoutTransaction(() -> libraryService.supportsPropagation());
    }

    @PostMapping("/propagation/mandatory")
    public void mandatoryPropagation() {
        // This method will be called within a transaction
        libraryService.callWithinTransaction(() -> libraryService.mandatoryPropagation());
        // This method will be called without a transaction
        libraryService.callWithoutTransaction(() -> libraryService.mandatoryPropagation());
    }

    @PostMapping("/propagation/requires-new")
    public void requiresNewPropagation() {
        libraryService.callWithinTransaction(() -> libraryService.requiresNewPropagation());
        libraryService.callWithoutTransaction(() -> libraryService.requiresNewPropagation());
    }
    @PostMapping("/propagation/not-supported")
    public void notSupportedPropagation() {
        libraryService.callWithinTransaction(() -> libraryService.notSupportedPropagation());
        libraryService.callWithoutTransaction(() -> libraryService.notSupportedPropagation());
    }
    @PostMapping("/propagation/never")
    public void neverPropagation() {
//        libraryService.callWithinTransaction(() -> libraryService.neverPropagation());
        libraryService.callWithoutTransaction(() -> libraryService.neverPropagation());
    }


}

/*
 * Copyright 2017-2018 by Wordline, an Atos Compagny. All rights reserved. This software is the
 * confidential and proprietary information of Atos ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Atos. En référence à l’article 17.2 du CCAP du marché
 * n°2016-05, passé entre l’ASIP Santé et la société Worldine et relatif aux Prestations de
 * construction, d’hébergement, d’exploitation des infrastructures téléphoniques, de déploiement
 * technique de la solution SI-Samu et de services téléphoniques, les droits de propriété
 * intellectuelle de Worldline sur ce programme seront cédés à l’ASIP Santé à l’issue du marché,
 * notifié le 5 mai 2017 pour une durée initiale de 5 ans et reconductible une fois pour une période
 * d’un an.
 */
/**
 * 
 */
package com.priceminister.account.utils;

/**
 * @author A672668
 */
public class Args {
    
    // ------------------------------------------------------------------------
    // Constructors
    // ------------------------------------------------------------------------
    
    /**
     * Default constructor, private on purpose.
     * 
     * @throws UnsupportedOperationException always.
     */
    private Args() {
        throw new UnsupportedOperationException();
    }
    
    // ------------------------------------------------------------------------
    // Args contract definition
    // ------------------------------------------------------------------------
    
    /**
     * Check that a given argument is not null.
     * 
     * @param o the argument to check.
     * @param msg the error message.
     * @return the argument.
     * @if <code>o</code> is not <code>null</code>.
     */
    public static <T> T notNull(T o, String msg) {
        if (o == null) {
            throw new IllegalArgumentException(msg);
        }
        return o;
    }
    
    // ------------------------------------------------------------------------
    // Args contract definition
    // ------------------------------------------------------------------------
    
    /**
     * Check that a given argument is null.
     * 
     * @param o the argument to check.
     * @param msg the error message.
     * @return the argument.
     * @if <code>o</code> is <code>null</code>.
     */
    public static <T> T isNull(T o, String msg) {
        if (o != null) {
            throw new IllegalArgumentException(msg);
        }
        return o;
    }
    
    /**
     * Check that a given numeric argument is positive, i.e. greater than zero.
     * 
     * @param l the argument to check.
     * @param msg the error message.
     * @return the argument.
     * @if <code>l</code> is negative or equal to zero.
     */
    public static Double positive(Double l, String msg) {
        if (l == null || l <= 0) {
            throw new IllegalArgumentException(msg);
        }
        return l;
    }
    
}

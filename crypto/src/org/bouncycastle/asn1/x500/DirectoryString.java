package org.bouncycastle.asn1.x500;

import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.DERBMPString;
import org.bouncycastle.asn1.DEREncodable;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERPrintableString;
import org.bouncycastle.asn1.DERString;
import org.bouncycastle.asn1.DERT61String;
import org.bouncycastle.asn1.DERUTF8String;
import org.bouncycastle.asn1.DERUniversalString;

public class DirectoryString
    extends ASN1Encodable
    implements ASN1Choice, DERString
{
    private DERString string;

    public static DirectoryString getInstance(Object o)
    {
        if (o instanceof DirectoryString)
        {
            return (DirectoryString)o;
        }

        if (o instanceof DERT61String)
        {
            return new DirectoryString((DERT61String)o);
        }

        if (o instanceof DERPrintableString)
        {
            return new DirectoryString((DERPrintableString)o);
        }

        if (o instanceof DERUniversalString)
        {
            return new DirectoryString((DERUniversalString)o);
        }

        if (o instanceof DERUTF8String)
        {
            return new DirectoryString((DERUTF8String)o);
        }

        if (o instanceof DERBMPString)
        {
            return new DirectoryString((DERBMPString)o);
        }

        throw new IllegalArgumentException("illegal object in getInstance");
    }

    private DirectoryString(
        DERT61String string)
    {
        this.string = string;
    }

    private DirectoryString(
        DERPrintableString string)
    {
        this.string = string;
    }

    private DirectoryString(
        DERUniversalString string)
    {
        this.string = string;
    }

    private DirectoryString(
        DERUTF8String string)
    {
        this.string = string;
    }

    private DirectoryString(
        DERBMPString string)
    {
        this.string = string;
    }

    public String getString()
    {
        return string.getString();
    }

    /**
     * <pre>
     *  DirectoryString ::= CHOICE {
     *    teletexString               TeletexString (SIZE (1..MAX)),
     *    printableString             PrintableString (SIZE (1..MAX)),
     *    universalString             UniversalString (SIZE (1..MAX)),
     *    utf8String                  UTF8String (SIZE (1..MAX)),
     *    bmpString                   BMPString (SIZE (1..MAX))  }
     * </pre>
     */
    public DERObject toASN1Object()
    {
        return ((DEREncodable)string).getDERObject();
    }
}
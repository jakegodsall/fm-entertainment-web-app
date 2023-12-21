"use client";

import React, { useState } from "react";

import Link from "next/link";

import Button from "../ui/Button";
import FloatingLabelFormInput from "./FloatingLabelFormInput";
import validateEmail from "@/utils/validators";

export default function SignUpForm() {
    const [fieldValues, setFieldValues] = useState({
        email: {
            value: "",
            hasBeenEdited: false,
            isValid: false,
        },
        password: {
            value: "",
            hasBeenEdited: false,
            isValid: false,
        },
        password2: {
            value: "",
            hasBeenEdited: false,
            isValid: false,
        },
    });

    function handleOnSubmit(event) {
        event.preventDefault();

        const fd = new FormData(event.target);
        const dataObj = Object.fromEntries(fd.entries());
    }

    function handleOnBlur(identifier) {
        setFieldValues((prevState) => ({
            ...prevState,
            [identifier]: {
                ...prevState[identifier],
                hasBeenEdited: true,
            },
        }));

        console.log(fieldValues);
    }

    function handleOnChange(identifier, event) {
        setFieldValues((prevValues) => ({
            ...prevValues,
            [identifier]: {
                ...prevValues[identifier],
                value: event.target.value,
            },
        }));
    }

    const emailIsInvalid =
        fieldValues.email.hasBeenEdited &&
        !validateEmail(fieldValues.email.value);

    console.log(emailIsInvalid);

    return (
        <form onSubmit={handleOnSubmit}>
            <h1 className="mb-[4rem] text-[3.2rem] font-extralight tracking-[-0.05rem]">
                Sign Up
            </h1>
            <div className="mb-[5.4rem] flex flex-col gap-[2.4rem]">
                <FloatingLabelFormInput
                    htmlFor="email"
                    label="Email address"
                    type="text"
                    onBlur={handleOnBlur}
                    onChange={handleOnChange}
                    value={fieldValues.email.value}
                    errorFlag={emailIsInvalid}
                    errorMessage="Email is invalid"
                />
                <FloatingLabelFormInput
                    htmlFor="password"
                    label="Password"
                    type="password"
                    onBlur={handleOnBlur}
                    onChange={handleOnChange}
                    value={fieldValues.password.value}
                />
                <FloatingLabelFormInput
                    htmlFor="password2"
                    label="Repeat Password"
                    type="password"
                    onBlur={handleOnBlur}
                    onChange={handleOnChange}
                    value={fieldValues.password2.value}
                />
            </div>
            <Button>Create an account</Button>
            <p className="mt-[2.4rem] text-center text-[1.5rem] font-extralight">
                Already have an account?{" "}
                <Link className="text-primary-red" href="/auth/login">
                    Login
                </Link>
            </p>
        </form>
    );
}

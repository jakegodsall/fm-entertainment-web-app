"use client";

import React, { useState } from "react";

import Link from "next/link";

import Button from "../ui/Button";
import FloatingLabelFormInput from "./FloatingLabelFormInput";
import { validateEmail, validatePassword } from "@/utils/validators";

export default function SignUpForm() {
    const [fieldValues, setFieldValues] = useState({
        email: {
            value: "",
            hasBeenEdited: false,
        },
        password: {
            value: "",
            hasBeenEdited: false,
        },
        password2: {
            value: "",
            hasBeenEdited: false,
        },
    });

    function handleOnSubmit(event) {
        event.preventDefault();

        const fd = new FormData(event.target);
        const dataObj = Object.fromEntries(fd.entries());
    }

    function handleOnBlur(identifier, event) {
        if (event.target.value === "") {
            setFieldValues((prevState) => ({
                ...prevState,
                [identifier]: {
                    ...prevState[identifier],
                    hasBeenEdited: false,
                },
            }));
        } else {
            setFieldValues((prevState) => ({
                ...prevState,
                [identifier]: {
                    ...prevState[identifier],
                    hasBeenEdited: true,
                },
            }));
        }
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

    const passwordIsInvalid =
        fieldValues.password.hasBeenEdited &&
        !validatePassword(fieldValues.password.value);

    const password2IsInvalid =
        fieldValues.password2.hasBeenEdited &&
        fieldValues.password.value !== fieldValues.password2.value;

    const inputsInvalid =
        emailIsInvalid || passwordIsInvalid || password2IsInvalid;

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
                    errorFlag={passwordIsInvalid}
                    errorMessage="Password is invalid"
                />
                <FloatingLabelFormInput
                    htmlFor="password2"
                    label="Repeat Password"
                    type="password"
                    onBlur={handleOnBlur}
                    onChange={handleOnChange}
                    value={fieldValues.password2.value}
                    errorFlag={password2IsInvalid}
                    errorMessage="The passwords must match"
                />
            </div>
            <Button disabled={inputsInvalid}>Create an account</Button>
            <p className="mt-[2.4rem] text-center text-[1.5rem] font-extralight">
                Already have an account?
                <span className="ml-[1rem]">
                    <Link className="text-primary-red" href="/auth/login">
                        Login
                    </Link>
                </span>
            </p>
        </form>
    );
}

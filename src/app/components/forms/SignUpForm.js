"use client";

import React, { useState } from "react";

import Link from "next/link";

import Button from "../ui/Button";
import FloatingLabelFormInput from "./FloatingLabelFormInput";

export default function SignUpForm() {
    const [enteredValues, setEnteredValues] = useState({
        email: "",
        password: "",
        password2: "",
    });

    function onSubmit(event) {
        event.preventDefault();

        const fd = new FormData(event.target);
        const dataObj = Object.fromEntries(fd.entries());

        console.log(dataObj);
    }

    function handleInputChange(identifier, event) {
        setEnteredValues((prevValues) => ({
            ...prevValues,
            [identifier]: event.target.value,
        }));

        console.log(enteredValues);
    }

    return (
        <form onSubmit={onSubmit}>
            <h1 className="mb-[4rem] text-[3.2rem] font-extralight tracking-[-0.05rem]">
                Sign Up
            </h1>
            <div className="mb-[5.4rem] flex flex-col gap-[2.4rem]">
                <FloatingLabelFormInput
                    htmlFor="email"
                    label="Email address"
                    type="text"
                    onChange={handleInputChange}
                    value={enteredValues.email}
                />
                <FloatingLabelFormInput
                    htmlFor="password"
                    label="Password"
                    type="password"
                    onChange={handleInputChange}
                    value={enteredValues.password}
                />
                <FloatingLabelFormInput
                    htmlFor="password2"
                    label="Repeat Password"
                    type="password"
                    onChange={handleInputChange}
                    value={enteredValues.password2}
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

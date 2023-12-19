import Image from "next/image";

import Card from "@/app/components/ui/Card";
import SignUpForm from "@/app/components/forms/SignUpForm";

export default function SignUpPage() {
    return (
        <Card>
            <SignUpForm />
        </Card>
    );
}

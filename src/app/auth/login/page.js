import Image from "next/image";

import Card from "@/app/components/ui/Card";
import LoginForm from "@/app/components/forms/LoginForm";

export default function LoginPage() {
    return (
        <Card>
            <LoginForm />
        </Card>
    );
}

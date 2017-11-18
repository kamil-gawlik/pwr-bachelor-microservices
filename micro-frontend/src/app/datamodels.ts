export interface ShortInfo{
  name: string;
  endpoints: string[];
}

export interface SingleEndpointConfiguration{
  name: string;
  path: string;
  method: string;
  input: FieldDefinition[];
  output: FieldDefinition[];
  consumes?: string,
  produces?: string
}

export interface FieldDefinition{
  name: string;
  type: string;
  required: boolean;
  additional_description?: string

}

